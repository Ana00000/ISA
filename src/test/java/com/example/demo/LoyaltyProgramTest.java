package com.example.demo;

import com.example.demo.model.LoyaltyProgram;
import com.example.demo.service.LoyaltyProgramService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoyaltyProgramTest {
    @Autowired
    private LoyaltyProgramService loyaltyProgramService;

    @Before
    public void setUp() throws Exception{
        LoyaltyProgram loyaltyProgram = new LoyaltyProgram();
        loyaltyProgram.setVerion(0L);
        loyaltyProgram.setDiscauntForGold(3);
        loyaltyProgram.setDiscauntForSilver(2);
        loyaltyProgram.setPointsForConsultation(1);
        loyaltyProgram.setPointsForGold(30);
        loyaltyProgram.setPointsForSilver(15);
        loyaltyProgram.setPointsForExamination(2);
        loyaltyProgramService.save(loyaltyProgram);
    }

    @Test(expected = ObjectOptimisticLockingFailureException.class)
    public  void test() throws Throwable{
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<?> future1 = executorService.submit(new Runnable() {
            @Override
            public void run() {
                LoyaltyProgram loyaltyProgram = loyaltyProgramService.findAll().get(0);
                loyaltyProgram.setPointsForGold(40);
                try {
                    Thread.sleep(3000);
                }catch (InterruptedException e){}
                loyaltyProgramService.save(loyaltyProgram);
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                LoyaltyProgram loyaltyProgram = loyaltyProgramService.findAll().get(0);
                loyaltyProgram.setPointsForGold(50);
                loyaltyProgramService.save(loyaltyProgram);
            }
        });

        try {
            future1.get(); // podize ExecutionException za bilo koji izuzetak iz prvog child threada
        } catch (ExecutionException e) {
            System.out.println("Exception from thread " + e.getCause().getClass()); // u pitanju je bas ObjectOptimisticLockingFailureException
            throw e.getCause();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
