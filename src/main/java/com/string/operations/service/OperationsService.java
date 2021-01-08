package com.string.operations.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class OperationsService {

	public List<String> getLongestString(List<String> list) {
		Optional<String> maxOp = list.stream()
									 .max(Comparator.comparingInt(String::length));
		String longest = maxOp.get();
		list.clear();
		list.add(longest);
		return list;
	}
	
	public List<String> deleteStringsMoreThan(List<String> list, int length){
		List<String> remainingList = list.stream().filter((x)->x.length()<=length).collect(Collectors.toList());
		return remainingList;
		
	}
}
