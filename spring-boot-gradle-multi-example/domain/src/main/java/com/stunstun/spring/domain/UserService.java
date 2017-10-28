package com.stunstun.spring.domain;

import com.google.api.client.util.Lists;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author minhyeok
 */
@Component("userService")
public class UserService {

    private final UserRepository userRepository;

    public UserService(ObjectProvider<UserRepository> repositoryProvider) {
        this.userRepository = repositoryProvider.getIfUnique();
    }

    public List<User> findAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    public List<User> findUsersByKeys(Long... args) {
        Iterable<User> iterable = userRepository.findAll();

        return StreamSupport.stream(iterable.spliterator(), false)
                .filter(u -> Arrays.asList(args).contains(u.getId()))
                .collect(Collectors.toList());
    }

    public List<Long> findKeysByField(String field) {
        Iterable<User> iterable = userRepository.findAll();

        return StreamSupport.stream(iterable.spliterator(), false)
                .filter(u -> field.equals(u.getField()))
                .sorted(Comparator.comparing(User::getId))
                .map(User::getId)
                .collect(Collectors.toList());
    }

    public List<String> findUserNamesByField(String field) {
        Iterable<User> iterable = userRepository.findAll();

        Stream<User> stream = StreamSupport.stream(iterable.spliterator(), false);

        Predicate<User> filterFunc = u -> field.equals(u.getField());
        Stream<User> filtered = stream.filter(filterFunc);

        Comparator<User> sortFunc = Comparator.comparing(User::getId);
        Stream<User> sorted = filtered.sorted(sortFunc);

        Function<User, String> mapFunc = User::getUserName;
        Stream<String> mapped = sorted.map(mapFunc);

        Collector<String, ?, List<String>> collector = Collectors.toList();
        return mapped.collect(collector);
    }
}
