/*
 * Copyright (c) 2017, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.s1asdev.jdbc.transactions.test1.servlet;

import java.util.*;
import java.lang.reflect.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import javax.naming.*;
import javax.rmi.PortableRemoteObject;
import javax.sql.*;
import com.sun.s1asdev.jdbc.transactions.test1.ejb.*;
 
public class bmservlet4 extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
                    throws ServletException, IOException
    {
         defaultAction(req, res);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse res)
                    throws ServletException, IOException
    {
         defaultAction(req, res);
    }

    public void displayMessage(HttpServletRequest req,
                      HttpServletResponse res,
                      String messageText)
                    throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println(messageText);
    }


    public void defaultAction(HttpServletRequest req, HttpServletResponse res)
                   throws ServletException, IOException
    {
     bmsample3home home = null;
     bmsample3 remote = null;
     res.setContentType("text/plain");
     PrintWriter out = res.getWriter();
     Context ctx;
	       
     try
      {
      Hashtable env = new Hashtable(1);
      env.put("javax.naming.factory.initial", "com.netscape.server.jndi.RootContextFactory");
      ctx = new InitialContext(env);

      Object objref = ctx.lookup("ejb/bmsamplebean3");
      home = (bmsample3home)PortableRemoteObject.narrow(objref, bmsample3home.class);
      remote = home.create();
      out.println("calling  bean1 ");
      out.println(" the result of invoking the ejb method is " + remote.performDBOps());
	   }
       catch (Exception e)
       {
	   System.out.println(" ERROR: " + e);
       }
        try
        {
    /*    javax.sql.DataSource ds,ds2;
        java.sql.Connection conn = null,conn2 = null;
        java.sql.Statement stmt = null,stmt2 = null;
        java.sql.ResultSet rs = null,rs2 = null;
	ctx = new InitialContext();
	ds = (DataSource)ctx.lookup("jdbc/ora1");
	ds2 = (DataSource)ctx.lookup("jdbc/ora2");
        
        conn = ds.getConnection();
	conn2 = ds2.getConnection();
	stmt=conn.createStatement();
	stmt2=conn2.createStatement();
	out.println("Verifying table contents ....");
	rs=stmt.executeQuery("select * from status1");
	int count=0;
         while (rs.next())
        {count++;
         out.println("record = "+rs.getString(1));
        }
         rs2=stmt2.executeQuery("select * from status2");
         int count2=0;
        while (rs2.next())
         {count2++;
         out.println("record = "+rs2.getString(1));
         }
         out.println("Total Records in table1 = "+count);
        out.println("Total Records in table2 = "+count2);
	if ((count==1)&&(count2==1))
         out.println("Result:PASS");
         else
         out.println("Result:FAIL");
   //      stmt.executeUpdate("delete from status1");
       //  stmt2.executeUpdate("delete from status2");
        // conn.commit();
       //  conn2.commit();  
         rs.close();
         out.println("deleted in 1");
         out.println("deleted in 2");
	 rs2.close();
         stmt.close();
	 stmt2.close();
	 conn.close();
	 conn2.close();*/
        }catch(Exception e){}			      
								      
	  
    }


}
