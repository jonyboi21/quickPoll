package com.apress.service;

import com.apress.domain.Poll;
import com.apress.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;


    public void createPoll(Poll poll) {
        pollRepository.save(poll);

    }

    public Iterable<Poll> getAllPolls() {
        return pollRepository.findAll();

    }


    public Optional<Poll> getPollById(Long id){
        Optional<Poll> p = pollRepository.findById(id);
        return p;
    }
    public void deletePoll(Long id){
        pollRepository.deleteById(id);
    }
    public void updatePoll(Long id, Poll p) {
        pollRepository.save(p);

    }

}