import Book from "../Book/Book.jsx";
import "./Bookshelf.css"

function Bookshelf() {
    const books = [
        {title:"A Game of Thrones", author:"George R.R. Martin", isbn: "9780007428540", pageCount: 694 },
        {title:"A Clash of Kings",author: "George R.R. Martin",isbn:"2",pageCount:768},
        {title:"A Storm of Swords",author: "George R.R. Martin",isbn:"3",pageCount:973},
        {title:"A Feast for Crows",author: "George R.R. Martin",isbn:"4",pageCount:753},
        {title:"A Dance with Dragons",author: "George R.R. Martin",isbn:"5",pageCount:1056},
        {title:"1984", author:"George Orwell", isbn:"7",pageCount:328},
        {title:"War and Peace", author: "Leo Tolstoy", isbn:"6",pageCount:1440},
    ];



    return (
        <div className="bookshelf" >
            {books.map(b => (
                <Book
                    key={b.isbn}
                    title={b.title}
                    author={b.author}
                    isbn={b.isbn}
                    pageCount={b.pageCount}
                />
            ))}
        </div>
    );
}

export default Bookshelf;