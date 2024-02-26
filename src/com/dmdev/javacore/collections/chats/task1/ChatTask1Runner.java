package com.dmdev.javacore.collections.chats.task1;

import com.dmdev.javacore.collections.chats.task1.entity.Chat;
import com.dmdev.javacore.collections.chats.task1.util.ChatUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatTask1Runner {

    public static void main(String[] args) {

        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat("firstChat", 2006));
        chats.add(new Chat("secondChat", 30));
        chats.add(new Chat("thirdChat", 1020));
        chats.add(new Chat("fourthChat", 50));
        chats.add(new Chat("fifthChat", 1050));
        chats.add(new Chat("aSuperChat", 1050));

        Collections.sort(chats);
        System.out.println(chats);

        ChatUtils.removeChatsWithUsersNumberLessThen(chats, 1000);
        System.out.println(chats);

        ChatUtils.sortChatsByDescendingUsersThenByName(chats);
        System.out.println(chats);
    }
}
