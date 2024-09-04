package com.example.demo.controller;

import com.example.demo.entity.ClientEntity;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller

public class ClientController {
    @Autowired
    private ClientRepository clientRepository;
    @GetMapping("/")
    public String showClient(Model model){
        List<ClientEntity> clients = (List<ClientEntity>) clientRepository.findAll();
        model.addAttribute("clients",clients);
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String showEditClientForm(@PathVariable("id") int id, Model model) {
        Optional<ClientEntity> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            ClientEntity client = optionalClient.get();
            model.addAttribute("client", client);
            return "clientform";
        } else {
            return "redirect:/";
        }
    }
    @PostMapping("/clients/save")
    public String saveClient(@ModelAttribute("") ClientEntity client, BindingResult result) {
        if (result.hasErrors()) {
            return "clientform"; // Quay lại trang chỉnh sửa nếu có lỗi
        }
        clientRepository.save(client); // Lưu thông tin khách hàng đã chỉnh sửa
        return "redirect:/"; // Chuyển hướng về danh sách khách hàng
    }
    @GetMapping("/clients/new")
    public String showNewClientForm(Model model) {
        model.addAttribute("client", new ClientEntity());
        return "newclient"; // Tên của template HTML
    }

    @PostMapping("/new")
    public String addClient( ClientEntity client) {
        clientRepository.save(client); // Lưu khách hàng
        return "redirect:/"; // Chuyển hướng đến danh sách khách hàng
    }
    @GetMapping(value = "/delete/{id}")
    public String deleteClient(@PathVariable int id) {
        clientRepository.deleteById(id);
        return "redirect:/";
    }
}
