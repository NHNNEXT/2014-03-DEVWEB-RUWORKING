/**  : 
 * @FileName : PstmtQuerySet.java
 * @Package : register
 * @작성자  : hataeho
 */
package db.query;

import java.util.List;

public class PstmtQuerySet {
	private List<Object> queryValues = null;
	private String sql = new String();
	private int querySetLength;
	
	public PstmtQuerySet(String sql, List<Object> queryValues){
		this.sql = sql;
		this.queryValues = queryValues;
		this.querySetLength = queryValues.size();
	}
	
	public String getSql(){
		return sql;
	}
	
	public Object getQueryValues(int index){
		return queryValues.get(index);
	}
	
	public int getQuerySetLength(){
		return querySetLength;
	}
}
