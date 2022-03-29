package com.bankingpgk;

import java.util.concurrent.locks.ReentrantLock;

public class IdGenerate {
    private static Long id=0L;
    private static ReentrantLock lock=new ReentrantLock();

    public static  long getNewId(){
        long result;
        lock.lock();
        try {
            result =++id;
        }finally {
            lock.unlock();
        }return result;
    }
    private IdGenerate(){}
}
