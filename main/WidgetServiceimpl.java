package com.erpbackend.production;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class WidgetServiceimpl implements WidgetService {

	private WidgetRepository repository;
	
	public WidgetServiceimpl(WidgetRepository repository) {
		this.repository= repository;
	}
	@Override
	public Optional<Widget> findById(Long id) {
		
		return repository.findById(id);
	}

	@Override
	public List<Widget> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Widget save(Widget widget) {
		widget.setVersion(widget.getVersion()+1);

        // Save the widget to the repository
        return repository.save(widget);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
