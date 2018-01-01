package cn.et.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import cn.et.model.MyNews;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class MyTimerTask extends TimerTask {

	MyNews myNews = new MyNews();
	@Override
	public void run() {
		//生成html
		//通过freemarker的Configuration读取相应的ftl文件
		try {
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
			//设置模板加载的方式，读取路径
			cfg.setDirectoryForTemplateLoading(new File("src/main/resources"));
			//指定模板如何查看数据模型
			cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_23));
			List<Map> list = myNews.queryNews();
			Map root = new HashMap();
			root.put("newsList", list);
			
			//实例化模板对象
			Template temp = cfg.getTemplate("index.ftl");
			//生成html文件，输出目标
			String htmlpath = "src/main/webapp/index.html";
			Writer out = new OutputStreamWriter(new FileOutputStream(htmlpath),"UTF-8");
			temp.process(root, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
