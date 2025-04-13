package top.example.service.impl;

import top.example.dao.ReviewDAO;
import top.example.dao.impl.ReviewDAOImpl;
import top.example.domain.Review;
import top.example.service.ReviewService;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {


    final private ReviewDAO reviewDAO = new ReviewDAOImpl();

    @Override
    public int getTotalReviewByUser(int uid) {
        return reviewDAO.getTotalReviewByUser(uid);
    }

    @Override
    public void addReview(Review review) {
        reviewDAO.addReview(review);
    }

    @Override
    public void deleteReview(int id) {
        reviewDAO.deleteReview(id);
    }

    @Override
    public Review getReviewById(int id) {
        return reviewDAO.getReviewById(id);
    }

    @Override
    public List<Review> findAllReview(int uid) {
        return reviewDAO.listReview(uid, 0, Short.MAX_VALUE);
    }

    @Override
    public List<Review> findSomeReview(int uid, int start, int count) {
        return reviewDAO.listReview(uid, start, count);
    }
}
