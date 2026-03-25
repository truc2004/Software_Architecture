package org.example.data_partition_horizontal.Service;

import org.example.data_partition_horizontal.Entity.UserAdult;
import org.example.data_partition_horizontal.Entity.UserYoung;
import org.example.data_partition_horizontal.Repository.UserYoungRepository;
import org.example.data_partition_horizontal.Repository.UserAdultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    @Autowired
    private UserYoungRepository youngRepo;

    @Autowired
    private UserAdultRepository adultRepo;

    public String getPartitionByAge(Integer age) {
        return (age < 20) ? "YOUNG" : "ADULT";
    }

    public void saveUser(String name, Integer age) {

        String partition = getPartitionByAge(age);

        if ("YOUNG".equals(partition)) {
            UserYoung u = new UserYoung();
            u.setName(name);
            u.setAge(age);
            youngRepo.save(u);

        } else {
            UserAdult u = new UserAdult();
            u.setName(name);
            u.setAge(age);
            adultRepo.save(u);
        }
    }
}