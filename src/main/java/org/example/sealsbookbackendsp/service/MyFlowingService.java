package org.example.sealsbookbackendsp.service;

import org.example.sealsbookbackendsp.model.MyFlowing;
import org.example.sealsbookbackendsp.repository.MyFlowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class MyFlowingService {

    @Autowired
    private MyFlowingRepository repository;

    public MyFlowing addFollowing(Long userId, Long storeId) {
        MyFlowing flowing = new MyFlowing();
        flowing.setUserId(userId);
        flowing.setStoreId(storeId);
        flowing.setCreateAt(new Timestamp(System.currentTimeMillis()));
        flowing.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return repository.save(flowing);
    }

    public boolean removeFollowing(Long userId, Long storeId) {
        Optional<MyFlowing> flowing = repository.findByUserIdAndStoreId(userId, storeId);
        if (flowing.isPresent()) {
            repository.delete(flowing.get());
            return true;
        }
        return false;
    }

    public List<MyFlowing> getAllFollowing(Long userId) {
        return repository.findAllByUserId(userId);
    }
}
