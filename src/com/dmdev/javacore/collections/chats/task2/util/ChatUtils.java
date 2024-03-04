package com.dmdev.javacore.collections.chats.task2.util;

import com.dmdev.javacore.collections.chats.task2.entity.Chat;
import com.dmdev.javacore.collections.chats.task2.entity.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ChatUtils {

    private static int MAJORITY_AGE = 18;

    private ChatUtils() {

    }

    public static List<User> getAdultUsersFromChats(List<Chat> chats) {
        List<User> adultUsers = new ArrayList<>();

        for (Chat chat : chats) {
            for (User user : chat.getUsers()) {
                if (user.getAge() > MAJORITY_AGE) {
                    adultUsers.add(user);
                }
            }
        }

        return adultUsers;
    }

    public static double countAverageAgeOfUsers(List<User> users) {
        int ageSum = 0;
        Iterator<User> userIterator = users.iterator();

        while (userIterator.hasNext()) {
            ageSum += userIterator.next().getAge();
        }
        return (double) ageSum / users.size();
    }
}
