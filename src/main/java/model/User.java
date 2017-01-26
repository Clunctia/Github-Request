package model;

import org.kohsuke.github.GHUser;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * @author kamontat
 * @version 1.0
 * @since 1/25/2017 AD - 10:42 PM
 */
public class User {
	public GHUser githubUser;
	public int id;
	public String loginName;
	public String name;
	public String surname;
	public String company;
	public String email;
	public String location;
	public URL url;
	public Date createAt;
	public Date updateAt;
	
	public User(GHUser ghUser) {
		this.githubUser = ghUser;
		try {
			id = ghUser.getId();
			loginName = ghUser.getLogin();
			
			if (ghUser.getName() != null) {
				String[] n = ghUser.getName().split(" ");
				name = n[0];
				if (n.length == 2) surname = n[1];
			}
			// else name = ghUser.getName();
			
			company = ghUser.getCompany();
			email = ghUser.getEmail();
			location = ghUser.getLocation();
			url = ghUser.getHtmlUrl();
			createAt = ghUser.getCreatedAt();
			updateAt = ghUser.getUpdatedAt();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "model.User{" + "id=" + id + ", loginName='" + loginName + '\'' + ", name='" + name + '\'' + ", company='" + company + '\'' + ", email='" + email + '\'' + ", location='" + location + '\'' + ", url=" + url + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
	}
}