package org.example.observer.task;

public class Main_Task {
    public static void main(String[] args) {
        ProjectTask task = new ProjectTask("Thiết kế hệ thống");

        TeamMember member1 = new TeamMember("Lan");
        TeamMember member2 = new TeamMember("Minh");

        task.registerObserver(member1);
        task.registerObserver(member2);

        task.setStatus("In Progress");
        task.setStatus("Completed");

    }
}
