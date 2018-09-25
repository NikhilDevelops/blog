package blog.database.daoService;


import blog.database.model.Post;

public interface PostDaoService {
	
	public abstract boolean addPost(Post post);
    public abstract boolean deletePost(Post post);
    public abstract boolean updatePost(Post post);
    public abstract Post getPostById(long postId);
}
