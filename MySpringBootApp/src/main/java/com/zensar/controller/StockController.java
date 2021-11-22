package com.zensar.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.zensar.dto.Stock;
import com.zensar.exception.InvalidStockIdException;

@RestController
public class StockController {
	private static Map<Integer,Stock> stockMap=new HashMap<Integer,Stock>();
	private static int lastStockId=3;
	
	static {
		stockMap.put(1, new Stock(1,"infosys","NSE",20000));
		stockMap.put(2, new Stock(2,"HCL","NSE",89000));
		stockMap.put(3, new Stock(3,"TCS","BSE",20000));
		
		
		
	}
	
	@ExceptionHandler(value = {InvalidStockIdException.class})
	public ResponseEntity<String> handleInvalidStockIdError(RuntimeException exception,WebRequest request){
		
		return new ResponseEntity<String>("Local Handler invalid stock id",HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping(value="/stock/{id}")
	public boolean deleteStockById(@PathVariable("id") int stockId) {
		stockMap.remove(stockId);
		return true;
		
		
		
	}
	@PutMapping(value="/stock/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Stock updateStockById(@PathVariable("id") int stockId,@RequestBody Stock newStock) {
		
		Stock existingStock=stockMap.get(stockId);
		existingStock.setMarket(newStock.getMarket());
		existingStock.setName(newStock.getName());
		existingStock.setPrice(newStock.getPrice());
		return existingStock;
		
		
		
	}
	@PostMapping(value="/stock",
			consumes= {MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE},
	produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Stock createNewStock(@RequestBody Stock stock) {
		lastStockId++;
		stock.setId(lastStockId);
		stockMap.put(lastStockId, stock);
		return stock;
		
		
		
	}
	@GetMapping(value="/stock/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Stock getStockById(@PathVariable("id")int stockId) {
		
		return stockMap.get(stockId);
		
		
		
	}
	@GetMapping(value="/stock",produces=MediaType.APPLICATION_JSON_VALUE)
	public Collection<Stock> getAllStocks(){
		
		return stockMap.values();
		
		
		
		
	}

}
