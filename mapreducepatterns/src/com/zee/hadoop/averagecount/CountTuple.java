package com.zee.hadoop.averagecount;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class CountTuple implements Writable {

	//<row Id="9" PostId="2" Score="0" 
	//Text="@CHM: [Mathjax 2.0, he means](http://www.mathjax.org/2012/02/11/news/mathjax-v2-0-beta-now-available-on-cdn/)" 
	//CreationDate="2012-04-26T04:24:06.183" UserId="22" />
	private String rowId;
	private String PostId;
	private String Score;
	private String comment;
	private String creationDate;
	private String userId;
	private static int count=0;
    @Override
    public void readFields(DataInput in) throws IOException {
        rowId=in.readLine();
        PostId=in.readLine();
        Score=in.readLine();
        comment=in.readLine();
        creationDate=in.readLine();
        userId=in.readLine();

    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeChars(rowId);
        out.writeChars(PostId);
        out.writeChars(Score);
        out.writeChars(comment);
        out.writeChars(creationDate);
        out.writeChars(userId);

    }
    public void setCount(int c){count=c;}
    public int getCount(){return count;}
	public String getScore() {
		return Score;
	}

	public void setScore(String score) {
		Score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getPostId() {
		return PostId;
	}

	public void setPostId(String postId) {
		PostId = postId;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		creationDate = creationDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		userId = userId;
	}



}
