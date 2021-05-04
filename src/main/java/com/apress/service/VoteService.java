package com.apress.service;

import com.apress.domain.Poll;
import com.apress.domain.Vote;
import com.apress.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private PollService pollService;

    public void postVote(Vote vote){
        vote = voteRepository.save(vote);

    }

    public Iterable<Vote> getVotes(Long pollId){
        return voteRepository.findByPoll(pollId);

    }


}
