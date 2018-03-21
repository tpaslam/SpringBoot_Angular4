import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'app';
  constructor(private http: HttpClient){
  }

  todoList:any=null;
  disableRowNum:number = -1;
  emptyTemplate = {"id":null,"todotext":"","status":0};



  ngOnInit(): void {
    this.http.get('./todo/fetchall/').subscribe(data => {
      this.todoList= data;
        console.log(data);
    });
  }

  deleteRecord(todo){
    this.http.delete('./todo/delete/'+todo.id).subscribe(data => {
      var index = this.todoList.indexOf(todo);
      console.log(index)
      if (index > -1) {
        this.todoList.splice(index, 1);
        console.log(this.todoList);
      }
    });
  }
  updateRecord(todo){
    this.http.post('./todo/update/',todo).subscribe(data => {
      var index = this.todoList.indexOf(todo);
      console.log(index)
      if (index > -1) {
        this.todoList[index]=data;
        this.emptyTemplate = {"id":null,"todotext":"","status":0};
        this.disableRowNum=-1;
        console.log(this.todoList);
      }
    });
  }
  editOrUpdate(rowIndex,todo){
    if(this.disableRowNum==rowIndex){
      this.updateRecord(todo);
    }else {
      this.disableRowNum = rowIndex;
    }

  }
  addRecord(){
      this.todoList.push(this.emptyTemplate);
      this.disableRowNum=this.todoList.length-1;
  }
  toDoDone(todo){
    var index = this.todoList.indexOf(todo);
    todo.status = 1;
    this.todoList[index]= todo;
    this.updateRecord(todo);
  }

}
