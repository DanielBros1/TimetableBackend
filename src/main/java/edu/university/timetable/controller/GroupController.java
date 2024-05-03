package edu.university.timetable.controller;


import edu.university.timetable.model.Group;
import edu.university.timetable.repository.GroupRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupRepository groupRepository;

    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping("")
    public List<Group> getAllGroups() {
        return groupRepository.getAllGroups();
    }

    @GetMapping("/{id}")
    public Group getGroupById(@PathVariable("id") int id) {
        return groupRepository.getGroupById(id);
    }

    @GetMapping("/course/{courseId}")
    public List<Group> getGroupByCourseId(@PathVariable("courseId") int courseId) {
        return groupRepository.getGroupByCourseId(courseId);
    }

    @PostMapping("")
    public void addGroup(@RequestBody Group group) {
        groupRepository.addGroup(group.getCourse().getId(), group.getTeacher().getId(), group.getGroupNumber(), group.getDateStarted(), group.getDateFinished(), group.getDayOfWeek(), group.getType());
    }
}
