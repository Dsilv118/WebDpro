package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;
import com.lec.ex.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// parameter을 받아서 DB에 저장
		String path = request.getRealPath("fileBoardUp");
		int maxSize = 1024*1024*5;
		String filename = "";
		MultipartRequest mRequest = null;
		int result = 0;
		BoardDao bDao = BoardDao.getInstance();
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mRequest.getFileNames();
			String param = paramNames.nextElement();
			filename = mRequest.getFilesystemName(param);
			int fid = Integer.parseInt(mRequest.getParameter("fid"));
			String mname = mRequest.getParameter("mname");
			String ftitle = mRequest.getParameter("ftitle");
			String fcontent = (mRequest.getParameter("fcontent")==null ? "" : mRequest.getParameter("fcontent"));
			String ffilename = filename != null ? filename : "NOIMG.JPG"; 
			Date frdate = new Date(System.currentTimeMillis());
			String fip = request.getRemoteAddr();
			request.setAttribute("modifyResult", bDao.modify(fid, ftitle, fcontent, ffilename, frdate, fip));
			request.setAttribute("pageNum", mRequest.getParameter("pageNum"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		InputStream  is = null;
		OutputStream os = null;
		try {
			File serverFile = new File(path + "/" + filename);
			if(serverFile.exists() && !filename.equals("NOIMG.JPG") && result==bDao.SUCCESS) {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:\\Dsilv\\source\\07_jQuery\\model2ex\\WebContent\\fileBoardUp\\"+filename);
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
