package com.example.mpkApp.serwisy;

import com.example.mpkApp.repozytoria.RozkladRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RozkladSerwis {
    private final RozkladRepo rozkladRepo;

    @Autowired
    public RozkladSerwis(RozkladRepo rozkladRepo) {
        this.rozkladRepo = rozkladRepo;
    }

    @Override
    public String toString() {
        return "RozkladSerwis{" +
                "rozkladRepo=" + rozkladRepo +
                '}';
    }
}
