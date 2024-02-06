import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PackageService {

  constructor(private httpClient: HttpClient) { }

  public createTransacion(amount: number){
    return this.httpClient.get("http://localhost:8085/createTransaction/"+amount);
  }                                                                  
}
