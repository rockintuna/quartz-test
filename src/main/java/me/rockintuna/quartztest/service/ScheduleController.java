package me.rockintuna.quartztest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/stop")
    public void stopSchedule() {
        scheduleService.stopSchedule();
    }

    @GetMapping("/pause")
    public void pauseSchedule() {
        scheduleService.pauseSchedule();
    }

    @GetMapping("/resume")
    public void resumeSchedule() {
        scheduleService.resumeSchedule();
    }

    @GetMapping("/register")
    public void registerJob(@RequestParam String key, @RequestParam String jobSays) {
        try {
            scheduleService.registerJob(key, jobSays);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/unregister")
    public void unregisterJob(@RequestParam String key) {
        try {
            scheduleService.unregisterJob(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
