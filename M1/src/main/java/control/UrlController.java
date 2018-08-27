package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Url;
import persistence.UrlDao;

@Controller
public class UrlController {
	
	@RequestMapping(value="/", method=RequestMethod.GET )
	public ModelAndView iniciar() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET )
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	@RequestMapping(value="/listar.htm", method=RequestMethod.GET )
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("consulta");
		try {
			mv.addObject("lista", new UrlDao().findAll());
			return mv;
		} catch (Exception e) {
			mv.addObject("msg", "Erro: "+e.getMessage());
			e.printStackTrace();
			return mv;
		}	
	}
	
	@RequestMapping(value="/delete.htm", method=RequestMethod.GET )
	public ModelAndView delete(Url u) {
		ModelAndView mv= new ModelAndView();
		try {
			new UrlDao().remove(u);
			return listar();
		} catch (Exception e) {
			mv.addObject("msg", "Erro: "+e.getMessage());
			e.printStackTrace();
			return listar();
		}
	}
		
	@RequestMapping(value="/gravar.htm", method=RequestMethod.POST)
	public ModelAndView gravar(Url u) {
		ModelAndView mv = new ModelAndView("index");
		try {
			Url url= new Url();
			url.setLongurl(u.getLongurl());
			url.setShorturl(new EncurtadorURL().sendGet(u.getLongurl())); 
			new UrlDao().persist(url);
			mv.addObject("msg", "URL encurtada!");
			return mv;
		} catch (Exception e) {
			mv.addObject("msg", "Erro: "+e.getMessage());
			e.printStackTrace();
			return mv;
		}
	}
	
	@RequestMapping(value="/edit.htm", method=RequestMethod.GET )
	public ModelAndView edit(Url u) {
		ModelAndView mv= new ModelAndView("edit");
		try {
			Url u2 = new UrlDao().findUrl(u.getId());
			mv.addObject("txt", "Editar URL");
			mv.addObject("u2", u2);
			return mv;
		} catch (Exception e) {
			mv.addObject("msg", "Erro: "+e.getMessage());
			e.printStackTrace();
			return listar();
		}
	}
	
	
	@RequestMapping(value="/update.htm", method=RequestMethod.POST)
	public ModelAndView update(Url u) {
		ModelAndView mv = new ModelAndView();
		try {
			u.setShorturl(new EncurtadorURL().sendGet(u.getLongurl()));
			new UrlDao().merge(u);
			return listar();
		} catch (Exception e) {
			mv.addObject("msg", "Erro: "+e.getMessage());
			e.printStackTrace();
			return mv;
		}
	}

}
