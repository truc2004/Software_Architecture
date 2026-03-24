from flask import Flask, render_template_string, request, redirect
import redis
import os

app = Flask(__name__)
r = redis.Redis(host='redis', port=6379)

@app.route('/', methods=['GET', 'POST'])
def vote():
    if request.method == 'POST':
        choice = request.form['choice']
        r.rpush('votes', choice)
        return redirect('/')
    return render_template_string('''
        <h1>Vote!</h1>
        <form method="post">
            <button name="choice" value="A">Option A</button>
            <button name="choice" value="B">Option B</button>
        </form>
    ''')

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)