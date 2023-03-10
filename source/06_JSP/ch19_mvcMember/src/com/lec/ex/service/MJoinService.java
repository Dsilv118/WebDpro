package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024*1024*5;
		String filename = "";
		MultipartRequest mRequest = null;
		int result = 0;
		MemberDao mDao = MemberDao.getInstance();
		try {
			// 첨부된 파일을 서버에 저장하고, 파일이름(mPhto) 가져오기
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mRequest.getFileNames();
			//while(paramNames.hasMoreElements()) { -- 파일이 하나밖에 없기때문에 while문은 안돌림
			String param = paramNames.nextElement();
			filename = mRequest.getFilesystemName(param);
			//}
			// mRequest를 이용하여 파라미터 받아와서 DB에 저장
			String mid = mRequest.getParameter("mid");
			String mpw = mRequest.getParameter("mpw");
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			String mphoto = filename != null ? filename : "NOIMG.JPG";
			Date mbirth = null;
			if(mRequest.getParameter("mbirth").equals("")) {
				mbirth = null;
			} else {
				mbirth = Date.valueOf(mRequest.getParameter("mbirth"));
			}
			String maddress = mRequest.getParameter("maddress");
			Timestamp mrdate = null;
			MemberDto newMember = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, mrdate);
			result = mDao.joinMember(newMember);
			HttpSession session = request.getSession();
			session.setAttribute("mid", mid);
			request.setAttribute("joinResult", result);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		InputStream  is = null;
		OutputStream os = null;
		try {
			File serverFile = new File(path + "/" + filename);
			if(serverFile.exists() && !filename.equals("NOIMG.JPG") && result==mDao.SUCCESS) {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:\\Dsilv\\source\\06_JSP\\ch19_mvcMember\\WebContent\\memberPhotoUp\\"+filename);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true) {
					int nReadCnt = is.read(bs);
					if(nReadCnt == -1) break;
					os.write(bs, 0, nReadCnt);
				}
				System.out.println("서버에 업로드한 파일을 서버폴더로 복사 성공");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try{
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch(IOException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}

}



























