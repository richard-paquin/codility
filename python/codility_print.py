def printable(func):
    """Execute the function and then print a string containing the args and the
    return value."""
    def print_wrapper(*args):
        _x = func(*args)
        s_var = ', '.join(repr(arg) for arg in args)
        if len(s_var) > 50:
            s_var = s_var[0:25] + '..........' + s_var[-15:len(s_var)]
        print "In:{} Out:{}".format(s_var, _x)
        return _x
    return print_wrapper
