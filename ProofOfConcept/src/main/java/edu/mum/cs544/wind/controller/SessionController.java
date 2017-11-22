package edu.mum.cs544.wind.controller;

import edu.mum.cs544.wind.domain.Session;
import edu.mum.cs544.wind.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("hasRole(Role.ROLE_ADMIN)")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping("/sessions")
    public Session addSession(@RequestBody Session session) {
        return sessionService.addSession(session);
    }

    @PutMapping("/sessions/{id}")
    public Session updateSession(@PathVariable Long id, @RequestBody Session session) throws Exception {
        return sessionService.updateSession(session);
    }

    @GetMapping("/sessions")
    public List<Session> getAllSession() {
        return sessionService.getAllSession();
    }

    @GetMapping("/sessions/{id}")
    public Session getSession(@PathVariable Long id) {
        return sessionService.getSession(id);
    }

    @DeleteMapping("/sessions/{id}")
    public void removeSession(@PathVariable Long id) {
        sessionService.removeSession(id);
    }
}