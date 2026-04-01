import "./Book.css";

function Book({ title, author, isbn, pageCount }) {
    const width = pageCount / 10;

    return (
        <div className="book" style={{ width: `${width}px` }}>
            <p className="book-title">{title}</p>
        </div>
    );
}

export default Book;