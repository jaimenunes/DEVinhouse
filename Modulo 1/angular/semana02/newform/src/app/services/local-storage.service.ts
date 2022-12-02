import { Injectable } from '@angular/core';

interface user{
  id: number,
  userEmail: string,
  userPassword: string
}

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {

  constructor() { }
  userAccounts: user[] = []

  setUserToLocalStorage(email: string, password: string){
    let user: user ={
      id: Date.now(),
      userEmail: email,
      userPassword: password
    }
    this.userAccounts.push(user)
    localStorage.setItem('users', JSON.stringify(this.userAccounts))
  }
}

