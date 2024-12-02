package ru.otus.homework.hw10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook = new HashMap<>();

    public void add(String fio, String phone) {
        if (phoneBook.containsKey(fio)) {
            phoneBook.get(fio).add(phone);
        }
        else {
            HashSet<String> hs = new HashSet<String>();
            hs.add(phone);
            phoneBook.put(fio, hs);
        }

    }

    public String find(String fio) {
        if (phoneBook.get(fio) == null)
            return "Номер не найден";
        else
            return phoneBook.get(fio).toString();
    }

    public boolean containsPhoneNumber(String phone) {
        for(Set s :phoneBook.values()) {
            if (s.contains(phone)) {
                return true;
            }
        }
        return false;
    }
}
