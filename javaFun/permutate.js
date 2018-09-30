function perms(pre, str, sol){
    if(str.length == 0 && !sol[pre]) {
        sol[pre]=1;
    } else {
        for(var i = 0;i<str.length;i++){
            perms(pre+str[i],str.slice(0,i)+str.slice(i+1,str.length), sol);
        }
    }
}
var a = {};
var b = [];
perms("","hello",a);
for(l in a){
    b.push(l);
}
console.log("ALL: "+b);