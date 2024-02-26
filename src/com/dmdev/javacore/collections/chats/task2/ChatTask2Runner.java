package com.dmdev.javacore.collections.chats.task2;

import com.dmdev.javacore.collections.chats.task2.entity.Chat;
import com.dmdev.javacore.collections.chats.task2.entity.User;
import com.dmdev.javacore.collections.chats.task2.util.ChatUtils;

import java.util.ArrayList;
import java.util.List;

public class ChatTask2Runner {

    public static void main(String[] args) {
        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat("chat1", List.of(
                new User(1, "Danila", 23),
                new User(2, "Alexandr", 17))));
        chats.add(new Chat("chat2", List.of(
                new User(3, "Anastasia", 16),
                new User(4, "Natalia", 20))));
        chats.add(new Chat("chat3", List.of(
                new User(5, "Ivan", 30),
                new User(6, "Nikita", 21))));
        chats.add(new Chat("chat4", List.of(
                new User(7, "Pavel", 27),
                new User(8, "Andrey", 24))));

        System.out.println(chats);

        List<User> adultUsers = ChatUtils.getAdultUsersFromChats(chats);
        System.out.println(adultUsers);

        System.out.println(ChatUtils.countAverageAgeOfUsers(adultUsers));

    }
}
