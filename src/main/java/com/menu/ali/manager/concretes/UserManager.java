package com.menu.ali.manager.concretes;

import com.menu.ali.Model.User;
import com.menu.ali.core.results.*;
import com.menu.ali.manager.abstracts.UserService;
import com.menu.ali.repositroy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManager implements UserService {

    private UserRepository userRepository;


    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Result add(User user) {
        userRepository.save(user);
        return new SuccessResult("user eklendi.");
    }

    @Override
    public Result update(User user) {
        userRepository.save(user);
        return new SuccessResult("user güncellendi.");
    }

    @Override
    public Result delete(int id) {
        userRepository.deleteById(id);
        return new SuccessResult("silindi");
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>(userRepository.findAll());
    }

    @Override
    public DataResult<User> getById(int id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new SuccessDataResult<User>(user, "Kullanıcı bulundu");
        } else {
            return new ErrorDataResult<User>("Kullanıcı bulunamadı");
        }


    }

    @Override
    public Result updateNewPassword(int userId, String newPassword) {

        // Kullanıcıyı veritabanından id ile alın
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Yeni şifreyi ayarlayın
            user.setPassword(newPassword);

            // Kullanıcıyı güncelleyin
            userRepository.save(user);

            return new SuccessResult("Şifre güncellendi.");
        } else {
            return new ErrorResult("Kullanıcı bulunamadı.");
        }

    }
}