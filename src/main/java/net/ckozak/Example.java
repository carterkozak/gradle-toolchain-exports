package net.ckozak;

public class Example {

    public static void main(String[] args) {
        sun.management.HotspotRuntimeMBean hotspotRuntimeManagementBean =
                sun.management.ManagementFactoryHelper.getHotspotRuntimeMBean();
        System.out.printf("Safepoint millis: %d\n", hotspotRuntimeManagementBean.getTotalSafepointTime());
    }
}
