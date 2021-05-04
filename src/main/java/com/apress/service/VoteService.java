package com.apress.service;

import com.apress.domain.Vote;
import com.apress.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private PollService pollService;

    public void postVote(Vote vote){
        voteRepository.save(vote);

    }

    public Iterable<Vote> getVotes(Long pollId){
        return voteRepository.findAll();

    }


    public void deleteVotes(Long voteId) {
        voteRepository.deleteById(voteId);
    }

    public Optional<Vote> getAVote(Long pollId) {
       return voteRepository.findById(pollId);
    }
}
