package dev.jcm.annotation.general.suppresswarnings;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class SuppressWarningExample {
    public void something() {
        List list = new ArrayList();
        list.add("data");
        System.out.println(list.getFirst());
    }
}
