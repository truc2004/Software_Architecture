package org.example.data_partition_horizontal.Service;

import org.example.data_partition_horizontal.Entity.UserFemale;
import org.example.data_partition_horizontal.Entity.UserMale;
import org.example.data_partition_horizontal.Repository.UserFemaleRepository;
import org.example.data_partition_horizontal.Repository.UserMaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMaleRepository maleRepo;

    @Autowired
    private UserFemaleRepository femaleRepo;

    public void saveUser(String name, String gender, Integer age) {

        if (gender == null) {
            throw new RuntimeException("Gender is null!");
        }

        gender = gender.toLowerCase();

        if (gender.equals("nam") || gender.equals("male")) {
            UserMale u = new UserMale();
            u.setName(name);
            u.setGender("Nam");
            u.setAge(age);
            maleRepo.save(u);

        } else {
            UserFemale u = new UserFemale();
            u.setName(name);
            u.setGender("Nu");
            u.setAge(age);
            femaleRepo.save(u);
        }
    }
}