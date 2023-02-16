package onecache;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Timer;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DefaultScheduler implements Scheduler {
    private ScheduledExecutorService executor;

    public DefaultScheduler() {
        // Use a thead pool of size ten for now since it should be sufficient.
        this.executor = Executors.newScheduledThreadPool(10);
    }

    @Override
    public Runnable RunOnceAfter(Runnable func, long delayMS) {
        Future future = this.executor.schedule(func, delayMS, TimeUnit.MILLISECONDS);
        return () -> future.cancel(true);
    }

//    public class testDefaultScheduler {
//        public void runDefaultScheduler (Map<String, Item> itemsMap) {
//            Set<Item> allItems = itemsMap.keySet();
//            LocalDateTime now = LocalDateTime.now();
//            LocalDateTime insertTime = item.insertTime;
//
//            for (Item it : allItems) {
//                long gapBetweenInsert = ChronoUnit.MILLIS.between(insertTime,now);
//
//                if (item.expireAfterMS != 0) {
//                    long expire = item.expireAfterMS;
//
//                    if (gapBetweenInsert > expire) {
//                        this.itemsByKey.remove(key);
//                    }
//                }
//            }
//
//        }
//    }

}
