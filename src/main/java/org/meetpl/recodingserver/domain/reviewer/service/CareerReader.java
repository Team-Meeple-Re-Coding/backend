package org.meetpl.recodingserver.domain.reviewer.service;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.domain.reviewer.domain.Career;
import org.meetpl.recodingserver.domain.reviewer.repository.CareerRepository;
import org.meetpl.recodingserver.global.error.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import static org.meetpl.recodingserver.global.error.ErrorCode.CAREER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CareerReader {
    private final CareerRepository careerRepository;
    public Career getCareerByReviewerId(Long reviewerId){
        return careerRepository.findByReviewerId(reviewerId).orElseThrow( () -> new EntityNotFoundException(CAREER_NOT_FOUND));
    }
}
