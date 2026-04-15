package org.example.data_partition_horizontal.Service;

import org.example.data_partition_horizontal.Entity.UserBasic;
import org.example.data_partition_horizontal.Entity.UserDetail;
import org.example.data_partition_horizontal.Repository.UserBasicRepository;
import org.example.data_partition_horizontal.Repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserBasicRepository basicRepo;

    @Autowired
    private UserDetailRepository detailRepo;

    public void saveUser(String name, String gender, Integer age) {

        // lưu bảng chính
        UserBasic basic = new UserBasic();
        basic.setName(name);
        basic.setGender(gender);

        basicRepo.save(basic);

        // lưu bảng phụ
        UserDetail detail = new UserDetail();
        detail.setId(basic.getId()); // liên kết id
        detail.setAge(age);

        detailRepo.save(detail);
    }
}