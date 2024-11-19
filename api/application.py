from flask import Flask

app = Flask(__name__)
from flask_sqlalchemy import SQLAlchemy



app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///data.db'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False  # Disable track modifications (optional, for better performance)

db = SQLAlchemy(app)

class Book(db.Model):
    id =db.Column(db.Integer, primary_key=True)
    title = db.Column(db.String(80), unique=True, nullable=False)
    author = db.Column(db.String(80), unique=True, nullable=False)

    def __repr__(self):
        return f"{self.title}-{self.author}"

@app.route('/')
def index():
    return 'Hello, World!'

@app.route('/books')
def get_books():
    return {'books': ['book1', 'book2', 'book3']}
