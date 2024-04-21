package edu.university.timetable.controller;


import edu.university.timetable.model.Group;
import edu.university.timetable.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping("")
    public List<Group> getAllGroups() {
        return groupRepository.getAllGroups();
    }

    @GetMapping("/{id}")
    public Group getGroupById(@PathVariable("id") int id) {
        return groupRepository.getGroupById(id);
    }

}
