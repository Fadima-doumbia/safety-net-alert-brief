package com.brief.safetyNetAlerts.controller;

import com.brief.safetyNetAlerts.Service.AlertService;
import com.brief.safetyNetAlerts.model.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping({"api/safetyNetAlets/alert"})
public class AlertController {

    @Autowired
    private AlertService alertService;

    @GetMapping("/list")
    public List<Alert> list() {
        return alertService.list();
    }

    @PostMapping("/addAlert")
    public Alert add(@RequestBody Alert alert) {
        return alertService.add(alert);
    }

    @GetMapping(path = {"/{id}"})
    public Optional<Alert> listId(@PathVariable("id") Long id) {
        return alertService.listId(id);
    }

    @PutMapping(path = {"/edit/{id}"})
    public Alert edit(@RequestBody Alert alert, @PathVariable("id") Long id) {
        alert.setId(id);
        return alertService.edit(alert);
    }

    @DeleteMapping(path = {"/delete/{id}"})
    public void delete(@PathVariable Long id) {
        alertService.deleteAlert(id);
    }

}
