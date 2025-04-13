package top.example.service;

import top.example.domain.Review;

import java.util.List;

/**
 * @Description: TODO
 * @Author: system
 * @Date: 2024-12-06
 */
public interface ReviewService {
    /**
     * 获取用户的所有评价
     *
     * @param: uid
     * @return: int
     */
    int getTotalReviewByUser(int uid);

    void addReview(Review review);

    void deleteReview(int id);

    Review getReviewById(int id);

    List<Review> findAllReview(int uid);

    List<Review> findSomeReview(int uid, int start, int count);
}
