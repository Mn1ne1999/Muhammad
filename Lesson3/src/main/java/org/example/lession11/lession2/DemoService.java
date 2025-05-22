package org.example.lession11.lession2;

import org.springframework.stereotype.Service;

@Service
@Timed          // замеряем все public-методы
public class DemoService {

    public void fast()           { sleep(50);  }
    @Timed                       // можно и так
    public void slow()           { sleep(300); }

    private void sleep(long ms)  { try { Thread.sleep(ms); } catch (InterruptedException ignored) {} }
}

