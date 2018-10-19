package bagas.meyca.apap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bagas.meyca.apap.entity.Jabatan;


@Controller
public class JabatanController {

//	Read Operation
	@RequestMapping(value = "/jabatan/view", method=RequestMethod.GET)
	private String viewJabatan(@RequestParam(value="id") Long id, Model model) {

		return "jabatan/jabatan";
	}
	
	@RequestMapping(value="/jabatan/viewall", method=RequestMethod.GET)
	public String viewAll(Model model) {

		return "jabatan/allJabatan";
	}
	
//	Add Operation
	@RequestMapping(value="/jabatan/tambah", method=RequestMethod.GET)
	private String tambah(Model model) {

		return "jabatan/addJabatan";
	}
	
	@RequestMapping(value="/jabatan/tambah", method=RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute Jabatan jabatan, Model model) {

		return "redirect:/";
	}
	
//	Update Operation
	@RequestMapping(value = "/jabatan/ubah/{id}", method=RequestMethod.GET)
	private String ubahJabatan(@PathVariable(value="id") Long id, Model model) {

		return "jabatan/editJabatan";
	}
	
	@RequestMapping(value="/jabatan/ubah", method=RequestMethod.POST)
	public String ubahJabatanSubmit(@ModelAttribute Jabatan jabatanBaru, Model model) {

		return "redirect:/";
	}
	
//	Delete Operation
	@RequestMapping(value="/jabatan/hapus/{id}", method=RequestMethod.GET)
	public String deletePilot(@PathVariable(value="id") Long id, Model model) {

		return "jabatan/deleteJabatan";
	}
	
//	Extra
	@RequestMapping(value="/jabatan/sebaran", method=RequestMethod.GET)
	public String sebaranKaryawan(Model model) {

		return "jabatan/statPegawai";
	}
}