package blog.database.daoService;

import blog.database.model.Comment;

public interface CommentDaoService {
	
	public abstract boolean addComment(Comment comment);
	public abstract boolean deleteComment(Comment comment);
	public abstract boolean updateComment(Comment comment);
	public abstract Comment getCommentById(long userId);
}
